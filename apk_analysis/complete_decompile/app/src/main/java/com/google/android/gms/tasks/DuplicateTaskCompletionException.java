package com.google.android.gms.tasks;

import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class DuplicateTaskCompletionException extends IllegalStateException {
    @NonNull
    /* renamed from: of */
    public static IllegalStateException m3750of(@NonNull Task<?> task) {
        String str;
        if (!task.isComplete()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception exception = task.getException();
        if (exception != null) {
            str = "failure";
        } else if (task.isSuccessful()) {
            str = "result ".concat(String.valueOf(task.getResult()));
        } else if (task.isCanceled()) {
            str = "cancellation";
        } else {
            str = "unknown issue";
        }
        return new IllegalStateException("Complete with: ".concat(str), exception);
    }
}
