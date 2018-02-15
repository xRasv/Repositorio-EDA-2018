/*
 * Esta es mi propia clase de sorts. En esta ocasión sólo he implementado mi 
 * variante del quicksort para optimizar el tamaño de la clase.
 */
package Packages;

/**
 *
 * @author Andrés
 */
public class Sorts {
    
        private void quicksortHelper(int[] v, int p, int n)
        {
            int t, pos;
            if (p < n)
            {
                pos = p;
                for (int i = p; i <= n; i++)
                    if (v[i] < v[n])
                    {
                        t = v[i];
                        v[i] = v[pos];
                        v[pos] = t;

                        pos++;
                    }

                t = v[n];
                v[n] = v[pos];
                v[pos] = t;

                quicksortHelper(v, p, pos - 1);
                quicksortHelper(v, pos + 1, n);

            }
        }
             
        /*Esta implementación del quicksort permite hacer su llamada pasando
        * como parámetro únicamente el vector a ordenar en su llamada principal.
        * quicksortHelper hace el procedimiento recursivo típico del alogrimto.
        */
        public void quicksort(int[] v)
        {          
            quicksortHelper(v, 0, v.length - 1);
        }
    
}
