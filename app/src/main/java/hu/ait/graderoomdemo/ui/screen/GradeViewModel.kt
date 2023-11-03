package hu.ait.graderoomdemo.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.ait.graderoomdemo.data.Grade
import hu.ait.graderoomdemo.data.GradeDAO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GradeViewModel @Inject constructor(
    private val gradeDAO: GradeDAO
): ViewModel() {

    fun addGrade(grade: Grade) { //scope --> when activity stops, stops the coroutine
        viewModelScope.launch(Dispatchers.IO) {
            gradeDAO.insert(grade)
        }
    }

    fun getAllGrades(): Flow<List<Grade>> {
        return gradeDAO.getAllGrades()
    }

    fun deleteAllGrades() {
        viewModelScope.launch(Dispatchers.IO) {
            gradeDAO.deleteAllGrades()
        }
    }

}