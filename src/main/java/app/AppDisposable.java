package app;

import com.intellij.openapi.Disposable;

public class AppDisposable implements Disposable {

    private static AppDisposable instance;

    private AppDisposable() {
    }

    public static AppDisposable getInstance() {
        if(instance == null) {
            instance = new AppDisposable();
        }
        return instance;
    }

    @Override
    public void dispose() {

    }
}
