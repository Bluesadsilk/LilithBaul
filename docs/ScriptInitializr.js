// URL base de tu API
const BASE_URL = 'http://localhost:4000';

// Función para enviar una solicitud POST
async function postData(url = '', data = {}) {
    const response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    });

    return response.json();
}

// Inicializar categorías, subcategorías y productos
async function initializeData() {
    try {
        // Crear categorías
        const categories = [
            { categoryName: 'Electronics' },
            { categoryName: 'Books' },
            { categoryName: 'Clothing' },
        ];

        const categoryPromises = categories.map(category =>
            postData(`${BASE_URL}/categories`, category)
        );
        const createdCategories = await Promise.all(categoryPromises);

        // Crear subcategorías
        const subcategories = [
            { subcategoryName: 'Mobile Phones', category: createdCategories[0].categoryId },
            { subcategoryName: 'Laptops', category: createdCategories[0].categoryId },
            { subcategoryName: 'Fiction', category: createdCategories[1].categoryId },
            { subcategoryName: 'Non-Fiction', category: createdCategories[1].categoryId },
            { subcategoryName: 'Men', category: createdCategories[2].categoryId },
            { subcategoryName: 'Women', category: createdCategories[2].categoryId },
        ];

        const subcategoryPromises = subcategories.map(subcategory =>
            postData(`${BASE_URL}/subcategories`, subcategory)
        );
        const createdSubcategories = await Promise.all(subcategoryPromises);

        // Crear productos
        const products = [
            { productName: 'iPhone 13', price: 999, subcategory: createdSubcategories[0].subcategoryId },
            { productName: 'MacBook Pro', price: 1999, subcategory: createdSubcategories[1].subcategoryId },
            { productName: 'The Great Gatsby', price: 10, subcategory: createdSubcategories[2].subcategoryId },
            { productName: 'Sapiens', price: 15, subcategory: createdSubcategories[3].subcategoryId },
        ];

        const productPromises = products.map(product =>
            postData(`${BASE_URL}/products`, product)
        );
        const createdProducts = await Promise.all(productPromises);

        console.log('Data initialized successfully:', { createdCategories, createdSubcategories, createdProducts });
    } catch (error) {
        console.error('Error initializing data:', error);
    }
}

// Ejecutar el script
initializeData();
