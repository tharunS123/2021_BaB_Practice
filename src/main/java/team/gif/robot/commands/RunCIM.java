package team.gif.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import team.gif.robot.Globals;
import team.gif.robot.subsystems.CIMshoot;
import team.gif.robot.Robot;
import team.gif.robot.subsystems.LimitSwitch;

public class RunCIM extends CommandBase {

    // T.SBab:
    boolean forward;

    public RunCIM(boolean isForward){
        forward = isForward;
    }

    // Called when the command is initially scheduled
    @Override
    public void initialize() {
        // T.SBab: have control of joystick
        Globals.g_buttonControl = true;
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        double speed = 0.2;

        // Limitswitch bumswitch == true speed == 0
        if ( Robot.mylimitSwitch.getLimitSwitch() == true ){
            speed = speed / 2;
        }

        // T.SBab: setting the speed for forward and reverse.
        if (forward){
            CIMshoot.getInstance().setSpeed(speed);
        } else {
            CIMshoot.getInstance().setSpeed(-speed);
        }

    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        // T.SBab: setting the set back to 0.
        CIMshoot.getInstance().setSpeed(0);
        Globals.g_buttonControl = false;
    }
}
