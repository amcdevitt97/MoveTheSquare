package edu.ycp.cs320.movethesquare.controllers;

import edu.ycp.cs320.movethesquare.model.Game;
import edu.ycp.cs320.movethesquare.model.Square;

public class GameController {
	public void computeSquareMoveDirection(Game game, Square square, double mouseX, double mouseY) {
		if (mouseX >= 0 && mouseX < game.getWidth() && mouseY >= 0 && mouseY < game.getHeight()) {
			double dx = mouseX - (square.getX() + square.getWidth()/2);
			double dy = mouseY - (square.getY() + square.getHeight()/2);
			
			double moveX = 0, moveY = 0;
			if (dx > 0) {
				moveX = Game.MOVE_DIST;
			} else {
				moveX = -Game.MOVE_DIST;
			}
			if (dy > 0) {
				moveY = Game.MOVE_DIST;
			} else {
				moveY = -Game.MOVE_DIST;
			}
			
			game.setSquareDx(moveX);
			game.setSquareDy(moveY);
		}
	}

	public void moveSquare(Game model, Square square) {
		//&&  && square.getY()>=0 && square.getY()< model.getHeight()
		if(square.getX()<=0){
			square.setX(square.getX()+5 + model.getSquareDx());
		}
		if(square.getX() >= (model.getWidth()-20)){
			square.setX(square.getX()-20 + model.getSquareDx());
		}
		if(square.getY()<=0){
			square.setY(square.getY()+5 + model.getSquareDy());
		}
		if(square.getY()>=(model.getHeight()-20)){
			square.setY(square.getY()-20 + model.getSquareDy());
		}
		if(square.getX()>=0 && square.getX()<= model.getWidth() && square.getY()>=0 && square.getY()<= model.getHeight()){
			square.setX(square.getX() + model.getSquareDx());
			square.setY(square.getY() + model.getSquareDy());
		}
	}
}
