package com.fosterb.platformer.model;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.fosterb.platformer.controller.LevelController;

import java.awt.Rectangle;

public class Bodies {

    public static void createBody(MapObject mapObject){
        String bodyType = mapObject.getProperties().get("type").toString();

        if(bodyType.equalsIgnoreCase("solid")){
            RectangleMapObject rectangleMapObject = (RectangleMapObject)mapObject;
            BodyDef bodyDefinition = new BodyDef();
            bodyDefinition.type = BodyDef.BodyType.StaticBody;
            bodyDefinition.position.set(rectangleMapObject.getRectangle().x * LevelController.UNIT_SCALE, rectangleMapObject.getRectangle().y * LevelController.UNIT_SCALE);

            Body physicsBody = LevelController.gameWorld.createBody(bodyDefinition);
            PolygonShape rectangleShape = new PolygonShape();
            rectangleShape.setAsBox(rectangleMapObject.getRectangle().width * LevelController.UNIT_SCALE / 2f, rectangleMapObject.getRectangle().height *
                    LevelController.UNIT_SCALE / 2f, new Vector2(rectangleMapObject.getRectangle().width * LevelController.UNIT_SCALE / 2f,
                    rectangleMapObject.getRectangle().height * LevelController.UNIT_SCALE / 2f), 0f);

            FixtureDef fixtureDefinition = new FixtureDef();
            fixtureDefinition.shape = rectangleShape;

            physicsBody.createFixture(fixtureDefinition);
            rectangleShape.dispose();
        }
        else if (bodyType.equalsIgnoreCase("ground")){
            PolylineMapObject polylineObject = (PolylineMapObject)mapObject;
            BodyDef bodyDefinition = new BodyDef();
            bodyDefinition.type = BodyDef.BodyType.StaticBody;
            bodyDefinition.position.set(polylineObject.getPolyline().getX() * LevelController.UNIT_SCALE,
                    polylineObject.getPolyline().getY() * LevelController.UNIT_SCALE);

            Body physicsBody = LevelController.gameWorld.createBody(bodyDefinition);
            ChainShape chainShape = new ChainShape();

            float[] transformedVertices = new float[polylineObject.getPolyline().getVertices().length];

            for (int index = 0; index < transformedVertices.length; index++){
                transformedVertices[index] = polylineObject.getPolyline().getVertices()[index] * LevelController.UNIT_SCALE;
            }

            chainShape.createChain(transformedVertices);

            FixtureDef fixtureDefinition = new FixtureDef();
            fixtureDefinition.shape = chainShape;
            fixtureDefinition.friction = 2.5f;

            physicsBody.createFixture(fixtureDefinition);
            chainShape.dispose();
        }
        else if(bodyType.equalsIgnoreCase("block")){
            RectangleMapObject rectangleMapObject = (RectangleMapObject)mapObject;
            BodyDef bodyDefinition = new BodyDef();
            bodyDefinition.type = BodyDef.BodyType.DynamicBody;
            bodyDefinition.position.set(rectangleMapObject.getRectangle().getX() * LevelController.UNIT_SCALE,
                    rectangleMapObject.getRectangle().getY() * LevelController.UNIT_SCALE);

            Body physicsBody = LevelController.gameWorld.createBody(bodyDefinition);
            PolygonShape rectangleShape = new PolygonShape();
            rectangleShape.setAsBox(rectangleMapObject.getRectangle().width * LevelController.UNIT_SCALE / 2f, rectangleMapObject.getRectangle().height *
                    LevelController.UNIT_SCALE / 2f, new Vector2(rectangleMapObject.getRectangle().width * LevelController.UNIT_SCALE / 2f,
                    rectangleMapObject.getRectangle().height * LevelController.UNIT_SCALE / 2f), 0f);

            FixtureDef fixtureDefinition = new FixtureDef();
            fixtureDefinition.shape = rectangleShape;

            physicsBody.createFixture(fixtureDefinition);
            rectangleShape.dispose();
        }
    }
}
