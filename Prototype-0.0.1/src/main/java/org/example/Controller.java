package org.example;

public abstract class Controller {

    private StoreSkeleton globalSkeleton;

    public void setSkeleton(StoreSkeleton skeleton){
        this.globalSkeleton = skeleton;
    }

    public StoreSkeleton getSkeleton() {
        return this.globalSkeleton;
    }
}