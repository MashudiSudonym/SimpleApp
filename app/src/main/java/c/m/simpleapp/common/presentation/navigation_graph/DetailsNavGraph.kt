package c.m.simpleapp.common.presentation.navigation_graph

import com.ramcosta.composedestinations.annotation.NavGraph
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph
@NavGraph
annotation class DetailsNavGraph(
    val start: Boolean = false
)
