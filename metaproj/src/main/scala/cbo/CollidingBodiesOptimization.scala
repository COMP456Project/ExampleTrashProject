package cbo

import scala.math._
import scala.util._
import breeze.linalg._
import breeze.stats.distributions._

object CollidingBodiesOptimization {
    def generateBodies(popSize: Int, nVar: Int, xMin: Int, xMax: Int) = {
        val solutions = DenseMatrix.rand[Double](popSize, nVar)
        solutions
    }

    //def findMass(fitness: )
}
