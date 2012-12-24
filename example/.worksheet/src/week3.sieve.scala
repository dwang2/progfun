package week3

object sieve {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(73); 
  println("Welcome to the Scala worksheet");$skip(51); 
  	def from(n: Int): Stream[Int] = n #:: from(n+1);System.out.println("""from: (n: Int)Stream[Int]""");$skip(20); 
	val nats = from(0);System.out.println("""nats  : Stream[Int] = """ + $show(nats ));$skip(28); 
	val m4s = nats map (_ * 4);System.out.println("""m4s  : scala.collection.immutable.Stream[Int] = """ + $show(m4s ));$skip(96); 


	def sieve(s: Stream[Int]): Stream[Int] =
		s.head #:: sieve(s.tail filter (_ % s.head != 0));System.out.println("""sieve: (s: Stream[Int])Stream[Int]""");$skip(29); 
	val primes = sieve(from(2));System.out.println("""primes  : Stream[Int] = """ + $show(primes ));$skip(25); val res$0 = 
	primes.take(200).toList;System.out.println("""res0: List[Int] = """ + $show(res$0))}
}