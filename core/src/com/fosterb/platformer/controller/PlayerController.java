package com.fosterb.platformer.controller;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.fosterb.platformer.model.Player;


public class PlayerController {

    public static Player player;
    public static String movementAction;
    public static String specialAction;

    public static boolean grounded;

    private enum State{
        Idle, Walk, Run, Swim, Duck, Hurt, Jump, Climb
    }
    private static State playerState;

    private static final float VELOCITY = 1f;
    private static final float MAX_VELOCITY = 5f;

    public static void initializeController(){
        player = new Player(new Vector2(3, 7), 70, 100, "img/aliens.png");
        movementAction = "";
        specialAction = "";
        playerState = State.Idle;
    }

    public static void update(float deltaTime){
        handleInput();
        //begins drawing the player
        player.update(deltaTime);
    }
    public static void draw(Batch spriteBatch){

        player.draw(spriteBatch);
    }
    private static void handleInput(){
        //gets velocity of physics body
        Vector2 velocity = player.physicsBody.getLinearVelocity();
        //gets position of physics body
        Vector2 position = player.physicsBody.getPosition();
        if(Math.abs(velocity.x) > MAX_VELOCITY) {
            velocity.x = Math.signum(velocity.x) * MAX_VELOCITY;
            //sets the velocity of the player
            player.physicsBody.setLinearVelocity(velocity.x, velocity.y);
        }
        //checks if a key has been pressed
        if(movementAction.equalsIgnoreCase("right")){
            player.physicsBody.applyLinearImpulse(VELOCITY, 0, position.x, position.y, true);
            player.direction = "right";
        }
        if(movementAction.equalsIgnoreCase("left")){
            player.physicsBody.applyLinearImpulse(-VELOCITY, 0, position.x, position.y, false);
            player.direction = "left";
        }
        if(specialAction.equalsIgnoreCase("jump") && PlayerController.grounded == true){
            player.physicsBody.applyLinearImpulse( 0, 3f, position.x, position.y, true);
            grounded = false;
        }

        if (Math.abs(velocity.x) > 0){
            playerState = State.Walk;
        }
        else{
            playerState = State.Idle;
        }
        setCurrentAnimation();

    }
    private static void setCurrentAnimation(){
        if (player.direction.equals("right")){
            setRightAnimation();
        }
        if (player.direction.equals("left")){
            setLeftAnimation();
        }
        if (player.direction.equals("jump")){
            setJumpAnimation();
        }
    }
    private static void setJumpAnimation(){
        if (playerState == State.Jump){
            player.currentAnimation = "jumpRight";
        }
        else if (playerState == State.Idle){
            player.currentAnimation = "idleRight";
        }
    }
    private static void setRightAnimation(){
        if (playerState == State.Walk){
            player.currentAnimation = "walkRight";
        }
        else if (playerState == State.Idle){
            player.currentAnimation = "idleRight";
        }
    }
    private static void setLeftAnimation(){

        if (playerState == State.Walk){
            player.currentAnimation = "walkLeft";
        }
        else if (playerState == State.Idle){
            player.currentAnimation = "idleLeft";
        }
    }
}
