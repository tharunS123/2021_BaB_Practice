package team.gif.robot.commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.CommandBase;
import team.gif.robot.Globals;
import team.gif.robot.Robot;
import team.gif.robot.subsystems.CIMshoot;
import team.gif.robot.commands.RunCIM;
import team.gif.robot.subsystems.LimitSwitch;

public class JoystickControl extends CommandBase {
    // Called when the command is initially scheduled
    @Override
    public void initialize() {
    }
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        if(!Globals.g_buttonControl){
            double CIMpercent = -Robot.oi.driver.getY(GenericHID.Hand.kLeft);
            if( Math.abs(CIMpercent) < 0.05){
                CIMpercent = 0;
            }
            int sign = (CIMpercent > 0) ? 1 : -1;
            CIMpercent = sign * Math.min(Math.abs(CIMpercent), 0.3);
            // T.SBaB: Rep 5
            if ( Robot.mylimitSwitch.getLimitSwitch() == true ){
                CIMpercent = CIMpercent / 2;
            }
            CIMshoot.getInstance().setSpeed(CIMpercent);

        }
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished(){
        return false;
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {}
}
