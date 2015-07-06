package Panels;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Stroke;

import javax.swing.JPanel;

import Default.Global;
import Utilities.MouseEvents;

//ChangeListener scrollbar yenilenmesini listen ettiriyor.
public class UmlPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private static UmlPanel instance = null;

	private UmlPanel() {
		super();

		this.addMouseListener(new MouseEvents());

		this.setPreferredSize(new Dimension(2000, 2000));

		this.setFocusable(true);
	}

	public static UmlPanel Get() {
		if (instance == null) {
			instance = new UmlPanel();
		}
		return instance;
	}

	public void DrawAggregationLine(int sx, int sy, int ex, int ey) {
		double H = Global.ARROW_HEIGHT;
		double L = Global.ARROW_WIDTH;
		int x3 = 0;
		int y3 = 0;
		int x4 = 0;
		int y4 = 0;
		int x5 = 0;
		int y5 = 0;

		double awrad = Math.atan(L / H);
		double arraow_len = Math.sqrt(L * L + H * H);

		double[] arrXY_1 = RotateVec(ex - sx, ey - sy, awrad, true, arraow_len);
		double[] arrXY_2 = RotateVec(ex - sx, ey - sy, -awrad, true, arraow_len);
		double[] arrXY_3 = RotateVec(ex - sx, ey - sy, 0, true, 2 * H);

		double x_3 = ex - arrXY_1[0];
		double y_3 = ey - arrXY_1[1];
		double x_4 = ex - arrXY_2[0];
		double y_4 = ey - arrXY_2[1];

		double x_5 = ex - arrXY_3[0];
		double y_5 = ey - arrXY_3[1];

		Double X3 = new Double(x_3);
		x3 = X3.intValue();
		Double Y3 = new Double(y_3);
		y3 = Y3.intValue();
		Double X4 = new Double(x_4);
		x4 = X4.intValue();
		Double Y4 = new Double(y_4);
		y4 = Y4.intValue();

		Double X5 = new Double(x_5);
		x5 = X5.intValue();
		Double Y5 = new Double(y_5);
		y5 = Y5.intValue();

		this.getGraphics().drawLine(sx, sy, x5, y5);
		this.getGraphics().drawLine(ex, ey, x3, y3);
		this.getGraphics().drawLine(ex, ey, x4, y4);
		this.getGraphics().drawLine(x3, y3, x5, y5);
		this.getGraphics().drawLine(x4, y4, x5, y5);
	}

	public void DrawInheritanceLine(int sx, int sy, int ex, int ey) {
		double H = Global.ARROW_HEIGHT;
		double L = Global.ARROW_WIDTH;
		int x3 = 0;
		int y3 = 0;
		int x4 = 0;
		int y4 = 0;
		int x5 = 0;
		int y5 = 0;

		double awrad = Math.atan(L / H);
		double arraow_len = Math.sqrt(L * L + H * H);

		double[] arrXY_1 = RotateVec(ex - sx, ey - sy, awrad, true, arraow_len);
		double[] arrXY_2 = RotateVec(ex - sx, ey - sy, -awrad, true, arraow_len);
		double[] arrXY_3 = RotateVec(ex - sx, ey - sy, 0, true, H);

		double x_3 = ex - arrXY_1[0];
		double y_3 = ey - arrXY_1[1];
		double x_4 = ex - arrXY_2[0];
		double y_4 = ey - arrXY_2[1];

		double x_5 = ex - arrXY_3[0];
		double y_5 = ey - arrXY_3[1];

		Double X3 = new Double(x_3);
		x3 = X3.intValue();
		Double Y3 = new Double(y_3);
		y3 = Y3.intValue();
		Double X4 = new Double(x_4);
		x4 = X4.intValue();
		Double Y4 = new Double(y_4);
		y4 = Y4.intValue();

		Double X5 = new Double(x_5);
		x5 = X5.intValue();
		Double Y5 = new Double(y_5);
		y5 = Y5.intValue();

		this.getGraphics().drawLine(sx, sy, x5, y5);
		this.getGraphics().drawLine(ex, ey, x3, y3);
		this.getGraphics().drawLine(ex, ey, x4, y4);

		this.getGraphics().drawLine(x3, y3, x4, y4);
	}

	public void DrawInterfaceLine(int sx, int sy, int ex, int ey) {
		Graphics2D g2d = (Graphics2D) this.getGraphics().create();

		double H = Global.ARROW_HEIGHT;
		double L = Global.ARROW_WIDTH;
		int x3 = 0;
		int y3 = 0;
		int x4 = 0;
		int y4 = 0;
		int x5 = 0;
		int y5 = 0;

		double awrad = Math.atan(L / H);
		double arraow_len = Math.sqrt(L * L + H * H);

		double[] arrXY_1 = RotateVec(ex - sx, ey - sy, awrad, true, arraow_len);
		double[] arrXY_2 = RotateVec(ex - sx, ey - sy, -awrad, true, arraow_len);
		double[] arrXY_3 = RotateVec(ex - sx, ey - sy, 0, true, H);

		double x_3 = ex - arrXY_1[0];
		double y_3 = ey - arrXY_1[1];
		double x_4 = ex - arrXY_2[0];
		double y_4 = ey - arrXY_2[1];

		double x_5 = ex - arrXY_3[0];
		double y_5 = ey - arrXY_3[1];

		Double X3 = new Double(x_3);
		x3 = X3.intValue();
		Double Y3 = new Double(y_3);
		y3 = Y3.intValue();
		Double X4 = new Double(x_4);
		x4 = X4.intValue();
		Double Y4 = new Double(y_4);
		y4 = Y4.intValue();

		Double X5 = new Double(x_5);
		x5 = X5.intValue();
		Double Y5 = new Double(y_5);
		y5 = Y5.intValue();

		Stroke dashed = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 9 }, 0);
		g2d.setStroke(dashed);
		g2d.drawLine(sx, sy, x5, y5);

		g2d.dispose();

		this.getGraphics().drawLine(ex, ey, x3, y3);
		this.getGraphics().drawLine(ex, ey, x4, y4);
		this.getGraphics().drawLine(x3, y3, x4, y4);
	}

	private double[] RotateVec(int px, int py, double ang, boolean isChLen, double newLen) {
		double mathstr[] = new double[2];
		double vx = px * Math.cos(ang) - py * Math.sin(ang);
		double vy = px * Math.sin(ang) + py * Math.cos(ang);
		if (isChLen) {
			double d = Math.sqrt(vx * vx + vy * vy);
			vx = vx / d * newLen;
			vy = vy / d * newLen;
			mathstr[0] = vx;
			mathstr[1] = vy;
		}
		return mathstr;
	}
}
