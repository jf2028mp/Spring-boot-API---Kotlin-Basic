package com.example.drop.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class User(@Id  @GeneratedValue(strategy= GenerationType.AUTO) val id:Long,var name:String,var email:String)