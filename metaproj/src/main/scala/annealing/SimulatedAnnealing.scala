package annealing

import breeze.linalg._
import breeze.stats.distributions._

object SimulatedAnnealing {

    var bestSolution: DenseVector[Double] = DenseVector.rand(1)
    var bestCost: Double = 1.0

    def anneal(dimensions: Int, temperature: Double, coolingValue: Double, iterations: Int) = {
        val oldSolution = DenseVector.rand(dimensions)
        val oldCost = AnnealingUtils.testCost(oldSolution)

        bestSolution = oldSolution
        bestCost = oldCost

        val best = solve(oldSolution, oldCost, temperature, coolingValue, iterations, 0)
        best
    }

    def solve(solution: DenseVector[Double], cost: Double, temperature: Double,
                    coolingValue: Double, iterations: Int, iteration: Int) {
        if(iteration < iterations) {
            val newSolution = AnnealingUtils.mutate(solution)
            val newCost = AnnealingUtils.testCost(newSolution)

            if(newCost < bestCost) {
                bestSolution = newSolution
                bestCost = newCost
            }

            val acceptanceProbability = AnnealingUtils.acceptanceProbability(cost, newCost, temperature)

            if(math.random >= acceptanceProbability) {
                solve(newSolution, newCost, temperature*coolingValue, coolingValue, iterations, iteration+1)
            } else {
                solve(solution, cost, temperature*coolingValue, coolingValue, iterations, iteration+1)
            }
        } else {
            println(solution)
            println(bestSolution)
            println(cost)
            println(bestCost)
        }
    }
}
