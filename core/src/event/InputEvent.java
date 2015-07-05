package event;

import geometry.geom2d.Point2D;

import com.jme3.network.serializing.Serializable;

@Serializable
public class InputEvent extends ToServerEvent {

	private String command;
	private double x;
	private double y;
	private Boolean isPressed;

	public InputEvent() {

	}

	public InputEvent(String command, Point2D point, Boolean isPressed) {
		this.command = command;
		this.x = point.x;
		this.y = point.y;
		this.isPressed = isPressed;
	}

	public InputEvent(String command, Point2D point) {
		this(command, point, false);
	}

	public String getCommand() {
		return command;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public Boolean getIsPressed() {
		return isPressed;
	}
}
