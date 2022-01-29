package team.gif.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import team.gif.robot.subsystems.NeoShooter;

public class NeoRPM extends CommandBase {
    public NeoRPM() {
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize(){
    }

    // T.SBaB: calling to set RPM to 2.5
    @Override
    public void execute() {
        NeoShooter.getInstance().setRPM(60);
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

    // T.SBab: Once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
        NeoShooter.getInstance().setRPM(0);
    }
}
