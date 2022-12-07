package com.unosquare.patterns.builder;

import java.util.Objects;

public class NyPizza extends Pizza{
    public enum Size{SMALL, MEDIUM,LARGE};
    private final Size size;
    //We pass this Builder as a parameter
    public static class Builder extends Pizza.Builder<Builder>{
        private final Size size;
        public Builder(Size size){
            this.size = Objects.requireNonNull(size);
        }


        @Override
        protected Builder self() {
            return this;
        }

        @Override
        NyPizza build() {
            return new NyPizza(this);
        }
    }

   private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }
}
