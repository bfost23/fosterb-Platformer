package com.fosterb.platformer.model;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.fosterb.platformer.controller.LevelController;

import java.util.HashMap;

public class Player {
    //sets the position and spritesheet variables
    public Vector2 position;
    public String currentAnimation;
    public SpriteSheet spriteSheet;
    private float stateTime;
    private HashMap<String, Animation> playerAnimations;

    public float width;
    public float height;

    public Player(int width, int height) {
        //sets the position of the player
        position = new Vector2(3, 6);
        playerAnimations = new HashMap<String, Animation>();
        this.width = width * LevelController.UNIT_SCALE;
        this.height = height * LevelController.UNIT_SCALE;

        spriteSheet = new SpriteSheet("img/aliens.png", width, height);
        //creates animation //puts string into hashmap
        playerAnimations.put("walk",  spriteSheet.createAnimation(20, 21, .09f));
        playerAnimations.put("walkleft", spriteSheet.flipAnimation(playerAnimations.get("walk"), true, false));
        playerAnimations.put("swim",  spriteSheet.createAnimation(18, 19, .09f));
        playerAnimations.put("swimleft", spriteSheet.flipAnimation(playerAnimations.get("swim"), true, false));
        playerAnimations.put("idle",  spriteSheet.createAnimation(17, 17, .09f));
        playerAnimations.put("idleleft", spriteSheet.flipAnimation(playerAnimations.get("idle"), true, false));
        playerAnimations.put("stand",  spriteSheet.createAnimation(11, 11, .09f));
        playerAnimations.put("duck",  spriteSheet.createAnimation(14, 14, .09f));
        playerAnimations.put("duckleft", spriteSheet.flipAnimation(playerAnimations.get("duck"), true, false));
        playerAnimations.put("jump",  spriteSheet.createAnimation(16, 16, .09f));
        playerAnimations.put("jumpleft", spriteSheet.flipAnimation(playerAnimations.get("jump"), true, false));
        playerAnimations.put("hurt",  spriteSheet.createAnimation(15, 15, .09f));
        playerAnimations.put("hurtleft", spriteSheet.flipAnimation(playerAnimations.get("hurt"), true, false));
        playerAnimations.put("climb",  spriteSheet.createAnimation(1, 2, .09f));


        currentAnimation = "walk";
        stateTime = 0f;

        //setting the properties of the body
        BodyDef bodyDefinition = new BodyDef();
        bodyDefinition.type = BodyDef.BodyType.DynamicBody;
        bodyDefinition.position.set(position);
        Body playerBody = LevelController.gameWorld.createBody(bodyDefinition);
        playerBody.setUserData(this);

        //sets the size for rectangleShape
        PolygonShape rectangleShape = new PolygonShape();
        rectangleShape.setAsBox(this.width / 2f, this.height / 2f, new Vector2(this.width / 2f, this.height / 2f), 0f);

        //defines the shape of the fixture
        FixtureDef fixtureDefinition = new FixtureDef();
        fixtureDefinition.shape = rectangleShape;

        //creates the fixture
        playerBody.createFixture(fixtureDefinition);
        rectangleShape.dispose();
    }
    public void draw(Batch spriteBatch){
        //connects to the spriteSheet and displayed the player

        spriteBatch.draw(playerAnimations.get(currentAnimation).getKeyFrame(stateTime, true), position.x, position.y, width, height);


    }
    public void update(float deltaTime){
        stateTime += deltaTime;

    }
}
