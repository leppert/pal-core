(ns pal.core.hash
  (:require [goog.crypt :as gc]
            [goog.crypt.Md5 :as Md5]
            [goog.crypt.Sha1 :as Sha1]
            [goog.crypt.Sha256 :as Sha256]
            [goog.crypt.Sha384 :as Sha384]
            [goog.crypt.Sha512 :as Sha512]))

(defn- digest [hasher bytes]
  (.update hasher bytes)
  (.digest hasher))

(defn sha1
  [bytes]
  (digest (gc/Sha1.) bytes))

(defn sha256
  [bytes]
  (digest (gc/Sha256.) bytes))

(defn sha384
  [bytes]
  (digest (gc/Sha384.) bytes))

(defn sha512
  [bytes]
  (digest (gc/Sha512.) bytes))
