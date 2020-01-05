package frc.robot;

import java.util.HashMap;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import static edu.wpi.first.wpilibj.XboxController.Button.*;


public class ButtonMap{
	private static HashMap<String, Integer> map;

	{
		map = new HashMap<String, Integer>();
		map.put("intake_in", kBumperLeft.value);
		map.put("intake_out", kBumperRight.value);
		map.put("conveyor_in", kX.value);
		map.put("conveyor_out", kY.value);
		map.put("intake_and_conveyor_in", kA.value);
		map.put("intake_and_conveyor_out", kB.value);
		
	}

	public static JoystickButton getButton(GenericHID stick, String button) {
		return new JoystickButton(stick, map.get(button));
	}
}