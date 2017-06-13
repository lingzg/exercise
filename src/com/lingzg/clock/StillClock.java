package com.lingzg.clock;

import java.awt.Color;
import java.awt.Graphics;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 浣跨敤JFrame瀹屾垚鍔ㄦ�妯℃嫙鏃堕挓锛屽湪闈㈡澘涓粯鍒舵椂閽熷苟鎻愬彇绯荤粺褰撳墠鏃跺埢銆�
 * 
 * @author lingzg
 *
 */
public class StillClock extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7133082228157406493L;
	/**
	 * @param args
	 */
	private int hour;
	private int minute;
	private int second;

	// 鏋勯�鍑芥暟
	public StillClock() {
		setCurrentTime();
	}

	public void setCurrentTime() {
		Calendar calendar = new GregorianCalendar();
		this.hour = calendar.get(Calendar.HOUR_OF_DAY);
		this.minute = calendar.get(Calendar.MINUTE);
		this.second = calendar.get(Calendar.SECOND);
	}
	
	// 杩斿洖灏忔椂
	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

	public int getSecond() {
		return second;
	}

	// 缁樺埗鏃堕挓
	public void paint(Graphics g) {
		super.paint(g);
		// 鍒濆鍖�
		int clockRadius = (int) (Math.min(getWidth(), getHeight()) * 0.8 * 0.5);
		int xCenter = getWidth() / 2;
		int yCenter = getHeight() / 2;
		// 鐢诲渾
		g.setColor(Color.black);
		g.drawOval(xCenter - clockRadius, yCenter - clockRadius, 2 * clockRadius, 2 * clockRadius);
		g.drawString("12", xCenter - 5, yCenter - clockRadius + 15);
		g.drawString("9", xCenter - clockRadius + 3, yCenter + 5);
		g.drawString("3", xCenter + clockRadius - 10, yCenter + 3);
		g.drawString("6", xCenter - 3, yCenter + clockRadius - 3);
		// 鐢荤閽�
		int sLength = (int) (clockRadius * 0.8);
		int xSecond = (int) (xCenter + sLength * Math.sin(second * (2 * Math.PI / 60)));
		int ySecond = (int) (yCenter - sLength * Math.cos(second * (2 * Math.PI / 60)));

		g.setColor(Color.red);
		g.drawLine(xCenter, yCenter, xSecond, ySecond);

		// 鐢诲垎閽�
		int mLenth = (int) (clockRadius * 0.65);
		int xMinute = (int) (xCenter + mLenth * Math.sin(minute * (2 * Math.PI / 60)));
		int yMinute = (int) (xCenter - mLenth * Math.cos(minute * (2 * Math.PI / 60)));
		g.setColor(Color.blue);
		g.drawLine(xCenter, yCenter, xMinute, yMinute);

		// 鐢绘椂閽�
		int hLength = (int) (clockRadius * 0.5);
		int xHour = (int) (xCenter + hLength * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
		int yHour = (int) (yCenter - hLength * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12)));
		g.setColor(Color.green);
		g.drawLine(xCenter, yCenter, xHour, yHour);

		// 鐢绘暟瀛楁椂閽�
		g.setColor(Color.black);
		DecimalFormat s = new DecimalFormat("00");
		g.drawString(s.format(getHour()) + ":" + s.format(getMinute()) + ":" + s.format(getSecond()), xCenter - 22,
				yCenter - clockRadius - 15);

	}

	public void action(){
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				setCurrentTime();
				repaint();
			}
		}, 0, 1000);
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("DiaplayClock");
		StillClock clock = new StillClock();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 350);
		frame.setVisible(true);
//		frame.setLocationRelativeTo(null);
		clock.setBackground(new Color(0xF8F8FF));
		frame.add(clock);
		clock.action();
	}
}
