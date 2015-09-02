package com.amo.tutorial.myFi.common

import com.google.common.base.Preconditions
import com.google.common.collect.ComparisonChain
import java.util.Objects
import kotlin.platform.platformStatic

class Fraction(_numerator: Int, _denominator: Int) : Comparable<Fraction> {

    private val numerator: Int
    private val denominator: Int

    init {
        Preconditions.checkArgument(_denominator != 0)

        var tempNumerator = _numerator
        var tempDenominator = _denominator

        if (_denominator < 0) {
            tempDenominator = -_denominator;
            tempNumerator = -_numerator;
        }
        if (tempNumerator == 0) {
            tempNumerator = 0;
            tempDenominator = 1;
        }
        val commonFactor = if (tempNumerator == 0 ) 1 else gcd(tempNumerator, tempDenominator);
        this.numerator = tempNumerator / commonFactor;
        this.denominator = tempDenominator / commonFactor;
    }

    companion object {
        platformStatic val ZERO = Fraction(0, 1)
        platformStatic val ONE = Fraction(1, 1)

        platformStatic private fun gcd(num: Int, den: Int): Int {
            var x = Math.abs(num);
            var y = Math.abs(den);
            while (x != y) {
                if (x > y) {
                    x -= y;
                } else {
                    y -= x;
                }
            }
            return x;
        }
    }

    fun getValue(): Double = 1.0 * numerator / denominator
    //return NumberHelper.divide(numerator,denominator, RoundingMode.HALF_EVEN);

    fun plus(augend: Fraction): Fraction {
        return Fraction(
                this.numerator * augend.denominator + augend.numerator * this.denominator,
                this.denominator * augend.denominator
        )
    }

    fun plus(numerator: Int, denominator: Int): Fraction = this + Fraction(numerator, denominator)

    fun minus(subtrahend: Fraction): Fraction = this + subtrahend.negate()

    fun negate(): Fraction = Fraction(-this.numerator, this.denominator)

    fun times(multiplicand: Fraction): Fraction = Fraction(this.numerator * multiplicand.numerator, this.denominator * multiplicand.denominator)

    fun times(multiplicand: Int) = Fraction(this.numerator * multiplicand, this.denominator)

    fun div(divisor: Fraction): Fraction = this * divisor.reverse()

    fun reverse(): Fraction = Fraction(this.denominator, this.numerator);

    override fun hashCode(): Int = Objects.hash(numerator, denominator);

    override fun equals(other: Any?): Boolean = other is Fraction && numerator == other.numerator && denominator == other.denominator

    override fun compareTo(other: Fraction): Int {
        return ComparisonChain.start()
                .compare(this.numerator, other.numerator)
                .compare(this.denominator, other.denominator).result();
    }

    override fun toString(): String = numerator.toString() + "/" + denominator.toString();

}