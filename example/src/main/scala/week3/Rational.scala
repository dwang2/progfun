package week3

class Rational(x: Int, y: Int) {
	require(y != 0, "denominator must be zero")
	private def gcd(a: Int, b: Int): Int = if(b==0) a else gcd(b,a%b)
	private val a = gcd(x,y)
	def numer = x
	def denom = y
	
	def this(x: Int) = this(x,1)
	
	def less(that: Rational) = numer*denom < that.numer*that.denom
	
	def max(that: Rational) = if(this.less(that)) that else this
	
	def + (that: Rational) =
		new Rational(
			numer*that.denom + that.numer*denom,
			denom*that.denom)
		
	override def toString = numer/a + "/" + denom/a
	
	def unary_- : Rational = new Rational(-numer,denom)
	
	def - (that: Rational) = this + -that
}