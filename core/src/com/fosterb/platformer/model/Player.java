package com.fosterb.platformer.model;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.fosterb.platformer.controller.LevelController;

public class Player extends Sprite{

    public Player(Vector2 position, int width, int height, String sheetPath) {
        //calling the parent and telling it to create itself
        super(position, width, height, sheetPath);
        //creates animation //puts string into hashmap
        playerAnimations.put("walkRight",  spriteSheet.createAnimation(20, 21, 0.3f));
        playerAnimations.put("walkLeft", spriteSheet.flipAnimation(playerAnimations.get("walkRight"), true, false));

        playerAnimations.put("swimRight",  spriteSheet.createAnimation(18, 19, 0.3f));
        playerAnimations.put("swimLeft", spriteSheet.flipAnimation(playerAnimations.get("swimRight"), true, false));

        playerAnimations.put("idleRight",  spriteSheet.createAnimation(17, 17, 0.3f));
        playerAnimations.put("idleLeft", spriteSheet.flipAnimation(playerAnimations.get("idleRight"), true, false));

        playerAnimations.put("stand",  spriteSheet.createAnimation(11, 11, 0.3f));

        playerAnimations.put("duckRight",  spriteSheet.createAnimation(14, 14, 0.3f));
        playerAnimations.put("duckLeft", spriteSheet.flipAnimation(playerAnimations.get("duckRight"), true, false));

        playerAnimations.put("jumpRight", spriteSheet.createAnimation(16, 16, 0.3f));
        playerAnimations.put("jumpLeft", spriteSheet.flipAnimation(playerAnimations.get("jumpRight"), true, false));

        playerAnimations.put("hurtRight",  spriteSheet.createAnimation(15, 15, 0.3f));
        playerAnimations.put("hurtLeft", spriteSheet.flipAnimation(playerAnimations.get("hurtRight"), true, false));

        playerAnimations.put("climb",  spriteSheet.createAnimation(11, 12, 0.3f));


        currentAnimation = "stand";


        //setting the properties of the body
        BodyDef bodyDefinition = new BodyDef();
        bodyDefinition.type = BodyDef.BodyType.DynamicBody;
        bodyDefinition.position.set(position);
        physicsBody = LevelController.gameWorld.createBody(bodyDefinition);
        physicsBody.setUserData(this);
        physicsBody.setFixedRotation(true);

        //sets the size for rectangleShape
        PolygonShape rectangleShape = new PolygonShape();
        rectangleShape.setAsBox(this.width / 2f, this.height / 2f, new Vector2(this.width / 2f, this.height / 2f), 0f);

        //defines the shape of the fixture
        FixtureDef fixtureDefinition = new FixtureDef();
        fixtureDefinition.shape = rectangleShape;
        fixtureDefinition.density = 0.5f;

        //creates the fixture
        physicsBody.createFixture(fixtureDefinition);
        rectangleShape.dispose();
    }
    public void draw(Batch spriteBatch){
        super.draw(spriteBatch);
    }
    public void update(float deltaTime){
        super.update(deltaTime);
    }
}
