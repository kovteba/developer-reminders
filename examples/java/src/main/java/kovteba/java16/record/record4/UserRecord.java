package kovteba.java16.record.record4;

import kovteba.concurrency.livelock.example2.User;// tag::User[]
public record UserRecord(Long id, String name, String email) {}
// end::User[]
