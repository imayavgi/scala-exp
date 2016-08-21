case class Portfolio(portId: Int, var totalMktVal : Double, positions: List[Position])
case class Position (portId : Int, posId: Int, 
				secId: String, secGic: String,
				qty: Double, mktVal: Double)

val myPort = new Portfolio(1,0,
					List(
						new Position(1, 1, "IBM", "TECH", 10.0,100.80),
						new Position(1, 2, "AAPL", "TECH", 11.0,102.20),
						new Position(1, 3, "GE", "UTIL", 12.0,120.80),
						new Position(1, 4, "TCS", "SVCS", 11.0,110.23),
						new Position(1, 5, "VGI", "FIN", 15.0,610.12)
					)
				)

myPort.totalMktVal = myPort.positions.map(_.mktVal).sum
myPort.positions.groupBy(_.secGic).foreach( { case(k,v) => println(k + " = " + v ) } )
myPort.positions.groupBy(_.secGic).mapValues(_.map(_.mktVal)).foreach( { case(k,v) => println(k + " = " + v ) } )
myPort.positions.groupBy(_.secGic).mapValues(_.map(_.mktVal).sum).foreach( { case(k,v) => println(k + " = " + v ) } )
myPort.positions.groupBy(_.secGic).mapValues(_.map(_.mktVal).sum/myPort.totalMktVal*100).foreach( { case(k,v) => println(k + " = " + v ) } )
println(myPort.totalMktVal)
