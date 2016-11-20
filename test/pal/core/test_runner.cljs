(ns pal.core.test-runner
 (:require [doo.runner :refer-macros [doo-tests]]
           [pal.core.codecs-test]
           [pal.core.hash-test]
           [cljs.nodejs :as nodejs]))

(try
  (.install (nodejs/require "source-map-support"))
  (catch :default _))

(doo-tests
 'pal.core.codecs-test
 'pal.core.hash-test)
