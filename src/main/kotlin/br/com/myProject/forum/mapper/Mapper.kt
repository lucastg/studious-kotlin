package br.com.myProject.forum.mapper

interface Mapper<T, U> {

    fun map(t: T): U
}
