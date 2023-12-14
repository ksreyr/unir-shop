import { describe, it, expect } from 'vitest';
import {withItem} from "./FilterUtils.tsx";

describe('testin for withItem', () => {
    const mockProduct = {
        nombre: "Producto1",
        categoria: "Categoria1"
    };

    it('filtra por categoría', () => {
        // @ts-ignore
        const filter = withItem(mockProduct);
        expect(filter.filterByCategoryWith("Categoria1")).toBeTruthy();
        expect(filter.filterByCategoryWith("Categoria2")).toBeFalsy();
    });

});