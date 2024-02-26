package com.store.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.notification.domain.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}