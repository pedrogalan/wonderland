(ns wonderland.core)

(defn who-are-you [input]
  (cond
    (= java.lang.String (class input)) "String - Who are you?"
    (= clojure.lang.Keyword (class input)) "Keyword - Who are you?"
    (= java.lang.Long (class input)) "Number - Who are you?"))

(defmulti who-are-you class)

(defmethod who-are-you java.lang.String [input]
  (str "String - who are you? " input))

(defmethod who-are-you clojure.lang.Keyword [input]
  (str "Keyword - who are you? " input))

(defmethod who-are-you java.lang.Long [input]
  (str "Number - who are you? " input))

(defmethod who-are-you :default [input]
  (str "I don't know you - who are you? " input))

(defn change-size [height]
  (if (< height 3)
    :grow
    :shrink))

(defmulti eat-mushroom change-size)

(defmethod eat-mushroom :grow [_]
  "Eat the right side to grow.")

(defmethod eat-mushroom :shring [_]
  "Eat the left side to shrink.")
