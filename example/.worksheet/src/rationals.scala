object rationals {import scala.runtime.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(46); 
  val x = new Rational(1,4);System.out.println("""x  : Rational = """ + $show(x ));$skip(10); val res$0 = 
  x.numer;System.out.println("""res0: Int = """ + $show(res$0));$skip(10); val res$1 = 
  x.denom;System.out.println("""res1: Int = """ + $show(res$1));$skip(32); 
  
  val y  = new Rational(1,4);System.out.println("""y  : Rational = """ + $show(y ));$skip(29); 
  val z  = new Rational(3,2);System.out.println("""z  : Rational = """ + $show(z ));$skip(8); val res$2 = 
  x + y;System.out.println("""res2: Rational = """ + $show(res$2));$skip(9); val res$3 = 
  x + -y;System.out.println("""res3: Rational = """ + $show(res$3));$skip(12); val res$4 = 
  x - y - z;System.out.println("""res4: Rational = """ + $show(res$4))}
}

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