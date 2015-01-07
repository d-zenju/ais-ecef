package analyze;

public class ECEF {
	
	final double PI = 3.1415926535898;
	final double A	= 6378137;
	final double ONE_F = 298.2577223563;
	final double B	= A * (1.0 - 1.0 / ONE_F);
	final double E2	 = (1.0 / ONE_F) * (2 - (1.0 / ONE_F));
	final double ED2 = E2 * A * A / (B * B);
	
	
	public static void main(String[] args){
		double phi 			= 35.6725;
		double lambda 	= 139.8064;
		
		/*
		double n;
		BigDecimal f = BigDecimal.valueOf(1 / 298.257233563);
		BigDecimal e = f.multiply(BigDecimal.valueOf(2)).subtract(f.multiply(f));
		double e1 = e.doubleValue();

		n = 6378137 / Math.sqrt(1 - e1 * e1 * Math.sin(Math.toRadians(phi)));

		double x = n * Math.cos(Math.toRadians(phi)) * Math.cos(Math.toRadians(lambda));
		double y = n * Math.cos(Math.toRadians(phi)) * Math.sin(Math.toRadians(lambda));

		System.out.println(x);
		System.out.println(y);
		*/
		
		ECEF test = new ECEF();
		double[] anser = new double[3];
		anser = test.ecef(phi, lambda, 19);
		System.out.println(anser[0]);
		System.out.println(anser[1]);
		System.out.println(anser[2]);
	}

	public double[] ecef(double phi, double lambda, double height){
		double[] ecef = new double[3];
		ecef[0] = (NN(phi)+height) * Math.cos(phi * PI / 180) * Math.cos(lambda * PI / 180);
		ecef[1] = (NN(phi)+height) * Math.cos(phi * PI / 180) * Math.sin(lambda * PI / 180);
		ecef[2] = (NN(phi) * (1 - E2) + height) * Math.sin(phi * PI / 180);
		
		return ecef;
	}
	
	public double NN(double p){
		  return  (A / Math.sqrt(1.0 - (E2) * (Math.sin(p * PI / 180.0) * (Math.sin(p * PI / 180.0) ))));
	}
}
