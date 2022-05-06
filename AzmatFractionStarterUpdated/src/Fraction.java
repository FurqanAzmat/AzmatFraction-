
public class Fraction {
	private int numerator;
	private int denom;
	private boolean isReduced;

	Fraction(int n, int d) throws Exception {
		if (d == 0) {
			throw new Exception("Denominator cannot be Zero");
		}

		numerator = n;
		denom = d;
		isReduced = false;
	}

	public int getNumerator() {
		return numerator;
	}

	public int getDenominator() {
		return denom;
	}

	public Fraction add(Fraction b) throws Exception {
		if (denom == b.getDenominator()) {
			return new Fraction(numerator + b.getNumerator(), denom);
		}
		int newDenominator = denom * b.getDenominator();
		int newNumerator = denom * b.getNumerator() + numerator * b.getDenominator();
		return new Fraction(newNumerator, newDenominator);
	}

	public Fraction multiply(Fraction c)throws Exception{
		int newNumerator = numerator * c.getNumerator();
		int newDenom = denom * c.getDenominator();
		return new Fraction(newNumerator,newDenom);
	}
	
	public void reduce() {
		int gcdValue = gcd(numerator, denom);
		numerator = numerator / gcdValue;
		denom = denom / gcdValue;
	}

	private void setReducedStatus() {
		if (gcd(numerator, denom) == 1) {
			isReduced = true;
		} else {
			isReduced = false;
		}
	}

	public boolean isReduced() {
		setReducedStatus();
		return isReduced;
	}

	private int gcd(int a, int b) {
		  if(b == 0)
		  {
		    return a;
		  }
		  return gcd(b, a % b);
		}

	@Override
	public String toString() {
		String out = String.format("%d\n---\n%d\n", numerator, denom);
		return out;
	}

}
