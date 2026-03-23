package com.m3ngsze.sentry.online_examination_aos_ui.common.data

import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.Room
import java.util.UUID

val mockRooms = listOf(
    Room(
        roomId = UUID.randomUUID(),
        roomName = "Math Class A",
        userId = UUID.randomUUID(),
        firstName = "John",
        lastname = "Doe",
        section = "A1",
        subject = "Mathematics",
        student = 25,
        limit = 30,
        isDeleted = false
    ),
    Room(
        roomId = UUID.randomUUID(),
        roomName = "Physics Class B",
        userId = UUID.randomUUID(),
        firstName = "Anna",
        lastname = "Smith",
        section = "B2",
        subject = "Physics",
        student = 20,
        limit = 25,
        isDeleted = false
    ),
    Room(
        roomId = UUID.randomUUID(),
        roomName = "Chemistry Class C",
        userId = UUID.randomUUID(),
        firstName = "David",
        lastname = "Lee",
        section = "C3",
        subject = "Chemistry",
        student = 18,
        limit = 20,
        isDeleted = null // simulate nullable case
    )
)