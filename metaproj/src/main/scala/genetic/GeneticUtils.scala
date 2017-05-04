package genetic

import scala.collection.mutable.StringBuilder
import scala.math._
import scala.util._
import breeze.linalg._
import breeze.stats.distributions._

object GeneticUtils {
    def mutate(parent: String) = {
        val u = Uniform(0, 1)
        val child = parent.map(xi =>
                        if((u.draw() < (1.0/parent.length).toDouble) && (xi == '0')) '1'
                        else if ((u.draw() < (1.0/parent.length).toDouble) && (xi == '1')) '0'
                        else xi)
        child
    }

    def crossover(left: String, right: String) = {
        val rnd = new Random
        val index = rnd.nextInt(left.length)

        val child = new StringBuilder

        for(i <- 0 to index - 1) {
            child += left(i)
        }
        for(i <- index to right.length - 1) {
            child += right(i)
        }
        child.toString()
    }

    def tournament(solutions: Array[DenseVector[Double]],
                    fitnesses: DenseVector[Double], tournamentSize: Int) = {
        val rnd = new Random
        val index = rnd.nextInt(solutions.length)
        var winner = solutions(index)
        var winnerFitness = fitnesses(index)

        for(i <- 1 to tournamentSize) {
            val competitorIndex = rnd.nextInt(solutions.length)
            val competitor = solutions(competitorIndex)
            val competitorFitness = fitnesses(competitorIndex)

            if(competitorFitness <= winnerFitness) {
                winnerFitness = competitorFitness
                winner = competitor
            }
        }
        winner
    }
}
