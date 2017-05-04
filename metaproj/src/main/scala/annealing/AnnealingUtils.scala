package annealing

import scala.math._
import breeze.linalg._
import breeze.stats.distributions._

object AnnealingUtils {

    def acceptanceProbability(oldCost: Double, newCost: Double, temperature: Double) = {
        exp((newCost - oldCost) / temperature)
    }

    def mutate(solution: DenseVector[Double]) = {
        val norm = Gaussian(-1, 1)
        solution.map(xi => (xi + (norm.draw() * 0.01)))
    }

    def linearCool(initialTemperature: Double, finalTemperature: Double,
                    coolingValue: Double, currentIteration: Int, totalIterations: Int) {
        initialTemperature - currentIteration * (initialTemperature - finalTemperature) / totalIterations
    }

    def exponentialCool(initialTemperature: Double, finalTemperature: Double,
                    coolingValue: Double, currentIteration: Int, totalIterations: Int) {
        initialTemperature * pow((finalTemperature / initialTemperature), (currentIteration / totalIterations))
    }

    def testCost(solution: DenseVector[Double]) = {
        solution.foldLeft(0.0)((sum, x) => sum + 10 + x * x - 10 * math.cos(2 * x * math.Pi))
    }
}
