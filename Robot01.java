// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
//import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.Relay;

import edu.wpi.first.wpilibj.Timer;
//import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */

  //right motors
private final WPI_VictorSPX rightMotor1 = new WPI_VictorSPX(1);
private final WPI_VictorSPX rightMotor2 = new WPI_VictorSPX(3);

//left motors
private final WPI_VictorSPX leftMotor1 = new WPI_VictorSPX(2);
private final WPI_VictorSPX leftMotor2 = new WPI_VictorSPX(4);

//Speed Controller Groups
private final MotorControllerGroup rightSpeedGroup = new MotorControllerGroup(rightMotor1, rightMotor2);
private final MotorControllerGroup leftSpeedGroup = new MotorControllerGroup(leftMotor1, leftMotor2);

//drivetrain
DifferentialDrive drivetrain = new DifferentialDrive(rightSpeedGroup, leftSpeedGroup);

//Intake Mechanism
Spark intake = new Spark(1);

//Shooter Mechanism
Relay shooter = new Relay(0);

//Feeder
Spark feeder = new Spark(0);

//Joystick
Joystick stick1 = new Joystick(0);
Joystick stick2 = new Joystick(1);

//Time
Timer timer = new Timer();

  @Override
  public void robotInit() {}

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {

    timer.reset();

    timer.start();
  }

  @Override
  public void autonomousPeriodic() {

   
  
    if (timer.get()<2){

      intake.set(1);
  
    }
  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {

    drivetrain.arcadeDrive(stick1.getX(), stick1.getY());
    
    boolean intakeButton = stick2.getRawButton(1);
    if (!intakeButton){
			intake.set(0);
		} else{
			intake.set(1);
		}


    boolean feederButton = stick2.getRawButton(2);
    if (!feederButton){
			feeder.set(0);
		} else{
			feeder.set(-1);
		}

    boolean shooterButton = stick2.getRawButton(6);
    if (!shooterButton){
			shooter.set(Value.kOff);
		} else{
			shooter.set(Value.kReverse);
		}
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}
}
