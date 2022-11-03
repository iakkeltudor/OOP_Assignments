package main;

import java.awt.Color;

/**
 * Represents a car.
 * The attributes are speed, engine power and color.
 * The methods are accelerate,
 * decelerate, getSpeed, getColor, getPower,
 * getAcceleration, and getMaxSpeed.
 *
 * @author Laboratory Team
 */

public class Car {
	private String brandName;
	private int speed = 0; // current car speed
	private Color color;
	private int power;
	private int accelerationStep = 0; // speed increase when gas pedal pushed
	private int maxSpeed;
	private int gear = 1;
	private int numberOfGears;
	private static final int MIN_SPEED = 0; // minimum speed for all cars: 0 km/h
	private static final int MAX_SPEED = 300; // speed limit on all cars: 300 km/h
	private static final int MIN_POWER = 4; // minimum power for all cars; no less than 4 bhp
	private static final int MAX_POWER = 500; // maximum power for all cars; no more than 500 bhp
	private static final int ACCELERATION_MIN_STEP = 1; // minimum speed increase per second when gas pedal pushed
	private static final int ACCELERATION_MAX_STEP = 30; // maximum speed increase per second when gas pedal pushed
	private static final int MIN_GEAR = 0;
	private static final int MAX_GEAR = 7;
	
	/**
	 * Constructor to create a new Car object
	 * @param brand name or manufacturer.
	 * @param color color of the Car object - one of Java color constants
	 * @param power engine power
	 * @param accelerationStep increase in speed when gas pedal pushed
	 */

	public Car(String brand, Color color, int power, int maxSpeed, int accelerationStep, int numberOfGears) {
		this.brandName = brand;
		this.color = color;
		this.power = (power > 4)? power : 4;
		this.numberOfGears = (numberOfGears > 7)? numberOfGears : 7;
		
		if(maxSpeed < 0) 
			this.maxSpeed = MIN_SPEED;
		else if(maxSpeed > MAX_SPEED) 
			this.maxSpeed = MAX_SPEED;
		else 
			this.maxSpeed = maxSpeed;
		
		if(power < MIN_POWER)
			this.power = MIN_POWER;
		else if(power > MAX_POWER)
			this.power = MAX_POWER;
		
		if(accelerationStep < ACCELERATION_MIN_STEP)
			this.accelerationStep = ACCELERATION_MIN_STEP;
		else if(accelerationStep > ACCELERATION_MAX_STEP)
			this.accelerationStep = ACCELERATION_MAX_STEP;
		else
			this.accelerationStep = accelerationStep;
		
		if(numberOfGears < MIN_GEAR)
			this.numberOfGears = MIN_GEAR;
		else if(numberOfGears > MAX_GEAR)
			this.numberOfGears = MAX_GEAR;
	}
	
	/**
	 * Simulates pressing the accelerator
	 * @return the new speed
	 */
	public int accelerate()
	{
		int newSpeed = speed + getAcceleration();
		if(newSpeed <= getMaxSpeed())
			speed = newSpeed;
		else
			speed = getMaxSpeed();
		return speed;
	}
	
	public int brake(int brakeIntensity)
	{
		if(speed > MIN_SPEED) {
				if(brakeIntensity == 1)
					speed -= 2;
				else if(brakeIntensity == 2)
					speed -= 5;
				else if(brakeIntensity == 3)
					speed -= 10;
				else if(brakeIntensity == 4)
					speed -= 15;
				else if(brakeIntensity == 5)
					speed -= 25;
				else
					speed -= 50;
		}
		if(speed < MIN_SPEED)
			speed = MIN_SPEED;
		return speed;
	}
	
	public int changeGear()
	{
		int numberOfGears = this.numberOfGears;
		if(gear <= numberOfGears) { //i don't know how to force a car with for example 5 gears to not reach 6th and 7th gear, i thought this might work but it seems like it doesn't
			if(gear == 1 && getSpeed() >= 20)
				gear++;
			else if(gear == 2 && getSpeed() <= 19 && getSpeed() >= MIN_SPEED)
				gear--;
		
			if(gear == 2 && getSpeed() >= 40)
				gear++;
			else if(gear == 3 && getSpeed() <= 39)
				gear--;
		
			if(gear == 3 && getSpeed() >= 60)
				gear++;
			else if(gear == 4 && getSpeed() <= 59)
				gear--;
		
			if(gear == 4 && getSpeed() >= 85)
				gear++;
			else if(gear == 5 && getSpeed() <= 84)
				gear--;
		
			if(gear == 5 && getSpeed() >= 110)
				gear++;
			else if(gear == 6 && getSpeed() <= 109)
				gear--;
		
			if(gear == 6 && getSpeed() >= 150)
				gear++;
			else if(gear == 7 && getSpeed() <= 149)
				gear--;
		
			if(gear == 7 && getSpeed() <= getMaxSpeed())
				gear = 7;
		}
		return gear;
	}
	/*
	 * Simulates releasing the accelerator
	 * @return the new speed
	 */
	public int decelerate()
	{
		if(speed > MIN_SPEED)
			speed--;
		return speed;
	}
	/*
	 * @return the current speed
	 */
	public int getSpeed()
	{
		return speed;
	}
	/*
	 * @return the max speed
	 */
	public int getMaxSpeed()
	{
		return MAX_SPEED;
	}
	public int getMinSpeed()
	{
		return MIN_SPEED;
	}
	/*
	 * @return the color of the car
	 */
	public Color getColor()
	{
		return color;
	}
	/*
	 * @return the brand name of the car
	 */
	public String getBrandName()
	{
		return brandName;
	}
	/*
	 * @return the car's acceleration step 
	 */
	public int getAcceleration()
	{
		return accelerationStep;
	}
	/*
	 * @return the power of the car
	 */
	public int getPower()
	{
		return power;
	}
	public int getGear()
	{
		return gear;
	}
}

class TestDrive
{
	public static void main(String[] args)
	{
		TestDrive td = new TestDrive();
		td.start();
	}
	private void start()
	{
		Car beetle = new Car("Volskwagen Beetle", Color.orange, 80, 160, 10, 5);
		System.out.println("Starting Beetle Test Drive!");
		driveCar(beetle);
		
		Car ferrari = new Car("Ferrari Testarosa", Color.red, 300, 280, 30, 6);
		System.out.println("Starting Ferrari Test Drive!");
		driveCar(ferrari);
		
		Car peugeot = new Car("Peugeot 308 SW", Color.black, 110, 230, 10, 5); // this is my car :)
		System.out.println("Starting Peugeot Test Drive!");
		driveCar(peugeot);
		
		Car bugatti = new Car("Bugatti Chiron", Color.cyan, 1500, 300, 30, 7);
		System.out.println("Starting Bugatti Test Drive!");
		driveCar(bugatti);
	}
	public static void driveCar(Car c)
	{
		System.out.println("Car is a " + c.getBrandName());
		System.out.println("colored " + c.getColor());
		System.out.println("\t engine power is " + c.getPower());
		System.out.println("speeding step is " + c.getAcceleration());
		//press the accelerator 15 "times"
		for(int i = 1; i <= 15; i++) {
			System.out.println("Accelerating: " + c.accelerate() + " km/h in gear " + c.changeGear());
		}
		//release the accelerator 5 "times"
		for(int i = 1; i <= 50; i++) {
			System.out.println("Decelerating: " + c.decelerate() + " km/h in gear " + c.changeGear());
		}
		for(int i = 1; i <= 6; i++) { //i used this 'for' loop just to test every brake intensity possible. Of course, we can choose whatever brake intensity we want to use at any point during our test drive.
			System.out.println("Braking: " + c.brake(i) + " km/h in gear " + c.changeGear());
		}
		if(c.getSpeed() == c.getMinSpeed())
			System.out.println("The car has stopped.");
		else
			System.out.println("Final Cruising Speed: " + c.getSpeed() + " km/h in gear " + c.changeGear());
	}
}
