package example

import breeze.linalg._
import java.io.File
import annealing.AnnealingUtils
import annealing.SimulatedAnnealing
import genetic._

object Hello extends Greeting with App {
  println(greeting)
  //val matrix = csvread(new File("data/diabetes.csv"), ',')
  //println(matrix)
  //val vector = DenseVector.ones[Double](5)
  //println(AnnealingUtils.mutate(vector))
  //println(AnnealingUtils.testCost(vector))
  //SimulatedAnnealing.anneal(7, 10000.0, 0.9, 1000000)
  //SimulatedAnnealing.anneal(7, 10000.0, 0.9, 1000000)
  //SimulatedAnnealing.anneal(7, 10000.0, 0.9, 1000000)
  //SimulatedAnnealing.anneal(7, 10000.0, 0.9, 1000000)
  println(GeneticUtils.mutate("10101010101010101010"))
  println(GeneticUtils.crossover("11111111", "00000000"))
}

trait Greeting {
  lazy val greeting: String = "hello"
}
