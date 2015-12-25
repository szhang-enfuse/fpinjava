package com.fpinjava.io.exercise13_09;


import com.fpinjava.common.Function;
import com.fpinjava.common.Nothing;

public interface IO<A> {

  static IO<Nothing> empty() {
    return  () -> Nothing.instance;
  }

  A run();

  default <B> IO<B> map(Function<A, B> f) {
    return () -> f.apply(this.run());
  }

  default <B> IO<B> flatMap(Function<A, IO<B>> f) {
    throw new IllegalStateException("To be implemented");
  }

  static <A> IO<A> unit(A a) {
    return () -> a;
  }
}
