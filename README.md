
----PRIMERO CARGAR EL DATA SET REQUERIDO----
El dataset que uso esta con el nombre :--


1.-Para que funcione correctamente con la parte del ML prediction debe tener el codigo en una VM o en COLAB.

LINK DE COLAB:https://colab.research.google.com/drive/1-9c3CO05Cn1gIZrpfXIL8b8fpkgamfz7


2.-Se debe crear una cuenta en Ngrok y obtener su propio codigo de autoKen y ese ingresarlo e remplazar en la linea 13 del codigo de COLAB.

3.-Tener en cuenta que al ejecutar este codigo de colab nos arrojara un link de NGROK que nos sirve para poder que la respuesta del modelo solo se use como una APi.

4.-En la parte inicial del servlet es donde se debe ingresa dicho link .

5.-Tambien se debe crear una cuenta en Ngrok y obtener su propio codigo de autoKen y ese ingresarlo en la linea 13 del codigo de COLAB.

6.- Tomar en cuenta todas estas modificaciones y el correcto uso de Ngrok.

7.-Ademas tomar en cuenta que el link lo proporciona sin ssl por temas de prueba pero se puede modificar, y al final cuando se hace la consulta de la 
prediccion es mediante "/predict" ya que hay es donde respondera.   Proba en Postman para mayor facilidad
