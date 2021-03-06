package de.uulm.pvs.rep.solution.lauchner.controller;

import de.uulm.pvs.rep.solution.data.GameDao;
import de.uulm.pvs.rep.solution.data.dto.GameDto;
import de.uulm.pvs.rep.solution.data.dto.PlayerDto;
import de.uulm.pvs.rep.solution.data.dto.PresetDto;
import de.uulm.pvs.rep.solution.game.Game;
import de.uulm.pvs.rep.solution.game.engine.GameFinishedListener;
import de.uulm.pvs.rep.solution.lauchner.constants.ActionConstants;
import de.uulm.pvs.rep.solution.lauchner.widgets.ButtonWidget;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Controller for the game. This controller starts the game an returns the points etc. a user got
 * while playing the game.
 * 
 * @author Christian van Onzenoodt
 */
public class GameController
    implements ActionListener, GameFinishedListener, GameSettingsChangeListener {

  private Game game;
  private PresetDto preset = null;
  private PlayerDto player = null;

  private GameDao gameDao = GameDao.getInstance();

  private JFrame gameFrame;

  private GameStateChangedListener gameStateChangedListener;

  private ButtonWidget buttonWidget;

  /**
   * Create a new GameController. This creates a game, a frame for the game, sets all default
   * options for this frame and registers all used listeners ({@link KeyListener} and
   * {@link GameFinishedListener})
   */
  public GameController() {

    this.buttonWidget = new ButtonWidget();
    this.buttonWidget.addActionListener(this);

    game = new Game();

    gameFrame = new JFrame();

    gameFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
    gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gameFrame.setLocationRelativeTo(null);
    gameFrame.add(game.getRenderPanel());
    gameFrame.setResizable(false);
    gameFrame.pack();

    game.registerListener(gameFrame);
    game.addGameFinishedListener(this);
  }

  /**
   * Starts a game. This methods sets the game-frame visible, brings the frame to front and starts
   * the game in a new {@link Thread}.
   */
  private void startGame() {

    // if the user selected a player and a preset, start the game
    // since we only enable the button if both are given
    if (preset != null && player != null) {
      gameFrame.setVisible(true);
      gameFrame.toFront();

      game.setPreset(this.preset, this.player);

      Thread gameThread = new Thread(game);
      gameThread.start();
    }
  }

  @Override
  public void actionPerformed(ActionEvent event) {

    switch (event.getActionCommand()) {
      case ActionConstants.START_GAME:
        System.out.println("[GameController] start game");
        this.startGame();
        break;

      case ActionConstants.IMPORT_SETTINGS:
        System.out.println("[SettingsController] Import");
        break;

      case ActionConstants.EXPORT_SETTINGS:
        System.out.println("[SettingsController] Export");
        break;

      default:
        break;
    }
  }

  public void registerGameStateChangedListener(GameStateChangedListener gameStateChangedListener) {
    this.gameStateChangedListener = gameStateChangedListener;
  }

  /**
   * If the {@link Game} has ended, add the game to the database, notify the
   * {@link SettingsController} and hide the frame.
   */
  @Override
  public void gameFinished(GameDto game) {
    // insert the game into the database
    this.gameDao.addGame(game);
    this.gameStateChangedListener.gameFinished(game);
    gameFrame.setVisible(false);
  }

  /**
   * If both (player and preset) are set -> enable button to start the game.
   */
  private void checkEnableStartButton() {
    if (this.preset != null && this.player != null) {
      this.buttonWidget.enableStartGameButton(true);
    } else {
      this.buttonWidget.enableStartGameButton(false);
    }
  }

  /**
   * User selected a preset. This method listens for changes in the {@link SettingsController}.
   */
  @Override
  public void presetChanged(PresetDto preset) {
    System.out.println("[GameController] preset has changed");
    this.preset = preset;
    this.checkEnableStartButton();
  }

  /**
   * User selected a player. This method listens for changes in the {@link SettingsController}.
   */
  @Override
  public void playerChanged(PlayerDto player) {
    System.out.println("[GameController] player has changed");
    this.player = player;
    this.checkEnableStartButton();
  }

  public JPanel getButtonWidget() {
    return this.buttonWidget;
  }
}
