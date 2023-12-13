package com.kaspersky.tutorial.screen

import android.view.View
import androidx.test.espresso.action.ViewActions
import com.kaspersky.kaspresso.screens.KScreen
import com.kaspersky.kaspresso.tutorial.R
import com.kaspersky.kaspresso.tutorial.lists.NoteListActivity
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher

object NoteListScreen : KScreen<NoteListScreen>() {

    override val layoutId: Int = R.layout.activity_note_list
    override val viewClass: Class<*> = NoteListActivity::class.java

    val rvNotes = KRecyclerView(
        builder = { withId(R.id.rv_notes) },
        itemTypeBuilder = { itemType(::NoteItem) }
    )

    class NoteItem(matcher: Matcher<View>) : KRecyclerItem<NoteItem>(matcher) {

        val noteContainer = KView(matcher) { withId(R.id.note_container) }
        val tvNoteId = KTextView(matcher) { withId(R.id.tv_note_id) }
        val tvNoteText = KTextView(matcher) { withId(R.id.tv_note_text) }

        fun swipeLeft() {
            view.perform(ViewActions.swipeLeft())
        }
    }
}
