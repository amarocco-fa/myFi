package com.amo.tutorial.myFi.common

import com.google.common.base.MoreObjects
import com.google.common.collect.ComparisonChain
import java.time.LocalDate
import java.time.Period
import java.util.Objects

class Interval private constructor(private val delegate: com.google.common.collect.Range<LocalDate>) : Comparable<Interval> {

    constructor(from: LocalDate, to: LocalDate) : this(com.google.common.collect.Range.closed(from, to))

    constructor(from: LocalDate, period: Period) : this(from, from.plus(period))

    fun getStart(): LocalDate = delegate.lowerEndpoint()
    fun getEnd(): LocalDate = delegate.upperEndpoint()
    fun isEmpty(): Boolean = getStart().isEqual(getEnd());
    fun encloses(other: Interval) = delegate.encloses(other.delegate);
    fun isConnected(other: Interval): Boolean = delegate.isConnected(other.delegate)
    fun intersection(connectedRange: Interval): Interval = Interval(delegate.intersection(connectedRange.delegate));
    fun contains(date: LocalDate): Boolean = delegate.contains(date)

    fun toPeriod(): Period = Period.between(delegate.lowerEndpoint(), delegate.upperEndpoint().plusDays(1))

    fun adjustTo(date: LocalDate): LocalDate {
        return if (date.isAfter(getEnd())) getEnd()
        else if (date.isBefore(getStart())) getStart()
        else date;
    }

    override fun compareTo(other: Interval): Int {
        return ComparisonChain.start()
                .compare(delegate.lowerEndpoint(), other.delegate.lowerEndpoint())
                .compare(delegate.upperEndpoint(), other.delegate.upperEndpoint())
                .result();
    }

    override fun equals(other: Any?): Boolean {
        if (this == other) return true;
        if (other == null || javaClass != other.javaClass) return false;
        val range1 = other as Interval;
        return delegate.equals(range1.delegate);
    }

    override fun hashCode(): Int = Objects.hashCode(delegate)

    override fun toString(): String = MoreObjects.toStringHelper(this).add("range", delegate).toString()

}