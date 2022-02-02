// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

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
private final WPI_VictorSPX rightMotor2 = new WPI_VictorSPX(2);

//left motors
private final WPI_VictorSPX leftMotor1 = new WPI_VictorSPX(3);
private final WPI_VictorSPX leftMotor2 = new WPI_VictorSPX(4);

//Speed Controller Groups
private final MotorControllerGroup rightSpeedGroup = new MotorControllerGroup(rightMotor1, rightMotor2);
private final MotorControllerGroup leftSpeedGroup = new MotorControllerGroup(leftMotor1, leftMotor2);

//drivetrain
DifferentialDrive drivetrain = new DifferentialDrive(leftSpeedGroup, rightSpeedGroup);

//Joysticks
Joystick stick1 = new Joystick(0);
Joystick stick2 = new Joystick(1);


  @Override
  public void robotInit() {}

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  drivetrain.arcadeDrive(stick1.getX(), stick1.getY(1));
  
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {

    drivetrain.arcadeDrive(stick1.getX(), stick1.getY());
 
    
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
