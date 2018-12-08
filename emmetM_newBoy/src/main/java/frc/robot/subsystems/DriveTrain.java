/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveArcade;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.


  WPI_TalonSRX leftFrontMotor = null;
  WPI_TalonSRX leftRearMotor = null;
  WPI_TalonSRX rightFrontMotor = null;
  WPI_TalonSRX rightRearMotor = null;

  DifferentialDrive differentialDrive = null;

  public DriveTrain() {
    //Talons
    leftFrontMotor = new WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_FRONT_MOTOR);
    leftRearMotor = new WPI_TalonSRX(RobotMap.DRIVETRAIN_LEFT_REAR_MOTOR);
    rightFrontMotor = new WPI_TalonSRX(RobotMap.DRIVETRAIN_RIGHT_FRONT_MOTOR);
    rightRearMotor = new WPI_TalonSRX(RobotMap.DRIVETRAIN_RIGHT_REAR_MOTOR);

    SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftFrontMotor, leftRearMotor);
    SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightFrontMotor, rightRearMotor);
    
    differentialDrive = new DifferentialDrive(leftMotors, rightMotors);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());

    setDefaultCommand(new DriveArcade());
  }

  public void arcadeDrive(double moveSpeed, double rotateSpeed) {
    differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);
  } 
}
