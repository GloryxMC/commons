package net.gloryx.commons.jhate.collections

typealias Filter<T> = (T) -> Boolean
typealias Replace<T> = (T) -> T
typealias Find<T> = Filter<T>
typealias Modify<T, R> = (T) -> R