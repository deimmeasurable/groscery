package com.example.grocery.auth.navigation.destination

import com.example.grocery.R

sealed class PrimaryDestination(
    val name : String,
    val startRoute: String,
    val rootRoute: String,
    val icon : String
) {
    object Cart : PrimaryDestination(
    name = "cart",
    startRoute ="cart",
    rootRoute ="explore_root",
    icon = R.drawable.search
    )
    object Explore : PrimaryDestination(
        name = "Explore",
        startRoute ="explore",
        rootRoute ="explore_root",
        icon = R.drawable.explore
    )
    object  : PrimaryDestination(
        name = "cart",
        startRoute ="explore",
        rootRoute ="explore_root",
        icon = R.drawable.search
    )
}