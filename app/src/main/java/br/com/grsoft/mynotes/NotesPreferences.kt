package br.com.grsoft.mynotes

import android.content.Context
import android.content.SharedPreferences

class NotesPreferences {
    var context: Context
    var preferences: SharedPreferences
    var editor: SharedPreferences.Editor

    private val SHARED_NOTES_PREFERENCES: String = "NOTES_PREFERENCES"
    private val KEY_NOTES_PREFERENCES: String = "notes"

    constructor(context: Context) {
        this.context = context
        preferences = context.getSharedPreferences(SHARED_NOTES_PREFERENCES, 0)
        editor = preferences.edit()
    }

    fun saveNotes(note: String) {
        editor.putString(KEY_NOTES_PREFERENCES, note)
        editor.commit()
    }
    val notes: String
        get() = preferences.getString(KEY_NOTES_PREFERENCES, "").toString()
}